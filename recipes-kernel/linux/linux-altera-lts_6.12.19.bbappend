# Add QEMU virt support for cyclone5-emulator
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Use kernel config fragments to add QEMU virt support
SRC_URI:append:cyclone5-emulator = " \
    file://qemu-console.cfg \
    file://qemu-pl011.cfg \
"

# For cyclone5-emulator, start with a minimal base defconfig
KBUILD_DEFCONFIG:cyclone5-emulator = "multi_v7_defconfig"
