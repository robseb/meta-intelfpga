FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://mount-cgroup.service \
    file://prepare-systemd-cgroups.service \
"

do_install:append() {
    # Install cgroup mount service for systemd cgroup support
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/mount-cgroup.service ${D}${systemd_system_unitdir}/mount-cgroup.service
        install -m 0644 ${WORKDIR}/prepare-systemd-cgroups.service ${D}${systemd_system_unitdir}/prepare-systemd-cgroups.service
    fi
}

FILES:${PN} += " \
    ${systemd_system_unitdir}/mount-cgroup.service \
    ${systemd_system_unitdir}/prepare-systemd-cgroups.service \
"

SYSTEMD_SERVICE:${PN} += " \
    mount-cgroup.service \
    prepare-systemd-cgroups.service \
"