FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Add Cyclone V emulation files
SRC_URI:append:cyclone5-emulator = " \
    file://cyclone5_emulation_defconfig \
    file://cyclone5-emulation.dts \
"

# Add Agilex 5 device tree and configuration
SRC_URI:append:agilex5 = " \
    file://agilex5.dts \
    file://agilex5_dynamiq.cfg \
"

SRC_URI:append:agilex5-emulator = " \
    file://agilex5-emulation.dts \
    file://agilex5_emulator_dynamiq.cfg \
"

# Copy the emulation defconfig to kernel source
do_configure:prepend:cyclone5-emulator() {
    cp ${WORKDIR}/cyclone5_emulation_defconfig ${S}/arch/arm/configs/
    cp ${WORKDIR}/cyclone5-emulation.dts ${S}/arch/arm/boot/dts/
}

# Copy Agilex 5 device tree and apply kernel configuration fragments
do_configure:prepend:agilex5() {
    cp ${WORKDIR}/agilex5.dts ${S}/arch/arm64/boot/dts/intel/
    if [ -f ${WORKDIR}/agilex5_dynamiq.cfg ]; then
        cat ${WORKDIR}/agilex5_dynamiq.cfg >> ${S}/.config || true
    fi
}

do_configure:prepend:agilex5-emulator() {
    cp ${WORKDIR}/agilex5-emulation.dts ${S}/arch/arm64/boot/dts/intel/
    if [ -f ${WORKDIR}/agilex5_emulator_dynamiq.cfg ]; then
        cat ${WORKDIR}/agilex5_emulator_dynamiq.cfg >> ${S}/.config || true
    fi
}