FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Add cyclone5-emulator as a compatible machine
COMPATIBLE_MACHINE:append = "|cyclone5-emulator"

# Add agilex3-emulator as a compatible machine
COMPATIBLE_MACHINE:append = "|agilex3-emulator"

# Add agilex5-emulator as a compatible machine
COMPATIBLE_MACHINE:append = "|agilex5-emulator"

# Add arria10-emulator as a compatible machine
COMPATIBLE_MACHINE:append = "|arria10-emulator"

# Add agilex7-emulator as a compatible machine
COMPATIBLE_MACHINE:append = "|agilex7-emulator"

# Add branch for cyclone5-emulator
KBRANCH:cyclone5-emulator ?= "v6.6/standard/base"

# Add branch for agilex3-emulator
KBRANCH:agilex3-emulator ?= "v6.6/standard/base"

# Add branch for agilex5-emulator
KBRANCH:agilex5-emulator ?= "v6.6/standard/base"

# Add branch for arria10-emulator
KBRANCH:arria10-emulator ?= "v6.6/standard/base"

# Add branch for agilex7-emulator
KBRANCH:agilex7-emulator ?= "v6.6/standard/base"

# Add device tree and configuration for cyclone5-emulator
# Note: cyclone5-emulator uses QEMU virt machine with built-in device tree
# We only add kernel configuration fragments, not custom device tree
SRC_URI:append:cyclone5-emulator = " \
    file://cyclone5-emulator.cfg \
    file://disable-altvipfb.cfg \
"

# Add device tree and configuration for agilex3-emulator
SRC_URI:append:agilex3-emulator = " \
    file://agilex3-emulation.dts \
    file://agilex3-emulator.cfg \
    file://qemu-console.cfg \
    file://agilex3-qemu-pl011.cfg \
    file://disable-altvipfb.cfg \
"

# Add device tree and configuration for agilex5-emulator
SRC_URI:append:agilex5-emulator = " \
    file://agilex5-emulation.dts \
    file://agilex5-emulator.cfg \
    file://qemu-console.cfg \
    file://agilex5-qemu-pl011.cfg \
    file://disable-altvipfb.cfg \
"

# Add device tree and configuration for arria10-emulator
SRC_URI:append:arria10-emulator = " \
    file://arria10-qemu-virt.dts \
    file://arria10_qemu_virt.cfg \
    file://arria10_qemu_virt_defconfig \
    file://disable-altvipfb.cfg \
"

# Add device tree and configuration for agilex7-emulator
SRC_URI:append:agilex7-emulator = " \
    file://agilex7-qemu-virt.dts \
    file://agilex7_qemu_virt.cfg \
    file://disable-altvipfb.cfg \
"

# Use standard defconfig approach for cyclone5-emulator (ARM32 QEMU virt)
KBUILD_DEFCONFIG:cyclone5-emulator ?= "multi_v7_defconfig"

# Use standard defconfig approach for agilex5-emulator (ARM64 QEMU virt)
KBUILD_DEFCONFIG:agilex5-emulator ?= "defconfig"

# Configure arria10-emulator and agilex7-emulator with custom defconfig
KBUILD_DEFCONFIG:arria10-emulator ?= "arria10_qemu_virt_defconfig"
KBUILD_DEFCONFIG:agilex7-emulator ?= "agilex7_qemu_virt_defconfig"

do_kernel_metadata:prepend:arria10-emulator() {
    # Copy defconfig to arch/arm/configs for arria10-emulator (ARM32)
    install -d ${S}/arch/arm/configs
    cp ${WORKDIR}/arria10_qemu_virt_defconfig ${S}/arch/arm/configs/
}

do_kernel_metadata:prepend:agilex7-emulator() {
    # Copy defconfig to arch/arm64/configs for agilex7-emulator (ARM64)
    install -d ${S}/arch/arm64/configs
    cp ${WORKDIR}/agilex7_qemu_virt_defconfig ${S}/arch/arm64/configs/
}

do_configure:prepend:agilex3-emulator() {
    # Copy device tree for ARM64
    install -d ${S}/arch/arm64/boot/dts/intel
    cp ${WORKDIR}/agilex3-emulation.dts ${S}/arch/arm64/boot/dts/intel/
}

do_configure:prepend:agilex5-emulator() {
    # Copy device tree for ARM64
    install -d ${S}/arch/arm64/boot/dts/intel
    cp ${WORKDIR}/agilex5-emulation.dts ${S}/arch/arm64/boot/dts/intel/
}

do_configure:prepend:arria10-emulator() {
    # Copy device tree for ARM32
    install -d ${S}/arch/arm/boot/dts
    cp ${WORKDIR}/arria10-qemu-virt.dts ${S}/arch/arm/boot/dts/
}

do_configure:prepend:agilex7-emulator() {
    # Copy device tree for ARM64
    install -d ${S}/arch/arm64/boot/dts/intel
    cp ${WORKDIR}/agilex7-qemu-virt.dts ${S}/arch/arm64/boot/dts/intel/
}

# Allow for missing features to not cause errors
KERNEL_DANGLING_FEATURES_WARN_ONLY:cyclone5-emulator = "1"
KERNEL_DANGLING_FEATURES_WARN_ONLY:agilex3-emulator = "1"
KERNEL_DANGLING_FEATURES_WARN_ONLY:agilex5-emulator = "1"
KERNEL_DANGLING_FEATURES_WARN_ONLY:arria10-emulator = "1"
KERNEL_DANGLING_FEATURES_WARN_ONLY:agilex7-emulator = "1"