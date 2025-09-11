# Disable WIC image creation for QEMU compatibility testing
# Force only ext4 image type to avoid WIC boot file issues

IMAGE_FSTYPES = "ext4 tar.gz"

# Clear WKS file to prevent WIC creation
WKS_FILE = ""

# Enable systemd and cgroups kernel features for proper service management
KERNEL_FEATURES:append = " features/cgroups/cgroups.scc features/systemd/systemd.scc"

# Add kernel boot parameters for proper cgroups v2 and systemd support
APPEND:append = " systemd.unified_cgroup_hierarchy=1 cgroup_enable=memory cgroup_enable=cpuset swapaccount=1 systemd.legacy_systemd_cgroup_controller=0 cgroup_no_v1=all systemd.show_status=yes"

# Ensure SSH and logging are available in all images
IMAGE_INSTALL:append = " openssh-sshd rsyslog rsyocto-kernel-dev"

# Add comprehensive kernel development support
IMAGE_INSTALL:append = " rsyocto-kernel-dev "

# Add essential build tools for kernel module compilation
IMAGE_INSTALL:append = " pkgconfig glibc-dev libgcc-dev "

# Ensure SSH and logging services are enabled at boot
ROOTFS_POSTPROCESS_COMMAND += "enable_ssh_and_rsyslog_units; "

enable_ssh_and_rsyslog_units() {
    if [ -d ${IMAGE_ROOTFS}${systemd_system_unitdir} ]; then
        # Create multi-user.target.wants and sockets.target.wants directories
        install -d ${IMAGE_ROOTFS}${systemd_system_unitdir}/multi-user.target.wants
        install -d ${IMAGE_ROOTFS}${systemd_system_unitdir}/sockets.target.wants
        install -d ${IMAGE_ROOTFS}${systemd_system_unitdir}/sysinit.target.wants
        
        # Enable sshd.service (main SSH daemon service we added via bbappend)
        if [ -f ${IMAGE_ROOTFS}${systemd_system_unitdir}/sshd.service ]; then
            ln -sf ../sshd.service \
                ${IMAGE_ROOTFS}${systemd_system_unitdir}/multi-user.target.wants/sshd.service
        fi
        
        # Also enable sshd.socket as backup (openssh-sshd socket activation)
        if [ -f ${IMAGE_ROOTFS}${systemd_system_unitdir}/sshd.socket ]; then
            ln -sf ../sshd.socket \
                ${IMAGE_ROOTFS}${systemd_system_unitdir}/sockets.target.wants/sshd.socket
        fi
        
        # Enable rsyslog
        if [ -f ${IMAGE_ROOTFS}${systemd_system_unitdir}/rsyslog.service ]; then
            ln -sf ../rsyslog.service \
                ${IMAGE_ROOTFS}${systemd_system_unitdir}/multi-user.target.wants/rsyslog.service
        fi
        
        # Enable ssh key generation service
        if [ -f ${IMAGE_ROOTFS}${systemd_system_unitdir}/sshdgenkeys.service ]; then
            ln -sf ../sshdgenkeys.service \
                ${IMAGE_ROOTFS}${systemd_system_unitdir}/multi-user.target.wants/sshdgenkeys.service
        fi
        
        # Enable cgroup mount service for systemd cgroup support
        if [ -f ${IMAGE_ROOTFS}${systemd_system_unitdir}/mount-cgroup.service ]; then
            ln -sf ../mount-cgroup.service \
                ${IMAGE_ROOTFS}${systemd_system_unitdir}/sysinit.target.wants/mount-cgroup.service
        fi
        
        # Enable systemd cgroup preparation service
        if [ -f ${IMAGE_ROOTFS}${systemd_system_unitdir}/prepare-systemd-cgroups.service ]; then
            ln -sf ../prepare-systemd-cgroups.service \
                ${IMAGE_ROOTFS}${systemd_system_unitdir}/sysinit.target.wants/prepare-systemd-cgroups.service
        fi
        
        # Enable rsyocto services if they exist
        if [ -f ${IMAGE_ROOTFS}${systemd_system_unitdir}/rsyocto-startup.service ]; then
            ln -sf ../rsyocto-startup.service \
                ${IMAGE_ROOTFS}${systemd_system_unitdir}/sysinit.target.wants/rsyocto-startup.service
        fi
        
        if [ -f ${IMAGE_ROOTFS}${systemd_system_unitdir}/rsyocto-runtime.service ]; then
            ln -sf ../rsyocto-runtime.service \
                ${IMAGE_ROOTFS}${systemd_system_unitdir}/multi-user.target.wants/rsyocto-runtime.service
        fi
    fi
}