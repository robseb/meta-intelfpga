FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://sshd.service"

do_install:append() {
    # Install the main sshd.service systemd unit file
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/sshd.service ${D}${systemd_system_unitdir}/sshd.service
    fi
}

FILES:openssh-sshd += "${systemd_system_unitdir}/sshd.service"

SYSTEMD_SERVICE:openssh-sshd += "sshd.service"