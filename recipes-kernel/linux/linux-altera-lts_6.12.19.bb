SUMMARY = "Linux kernel for Intel FPGA SoC - 6.12.19"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 6.12.19"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

require linux-altera.inc

LINUX_VERSION = "6.12.19"
SRCREV = "7b497655d942b6a44a87a2367463967e433ad422"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-6.12.19-lts"

# Override the SRC_URI and repository settings from linux-altera.inc
KERNEL_REPO = "git://github.com/altera-fpga/linux-socfpga.git"
SRC_URI = "${KERNEL_REPO};protocol=https;branch=${KBRANCH} \
           file://agilex5_qemu_virt_defconfig \
           file://module_support.cfg"

# Use the agilex5_qemu_virt_defconfig for ARM64 QEMU emulation
KBUILD_DEFCONFIG = ""
KERNEL_DEFCONFIG = "${WORKDIR}/agilex5_qemu_virt_defconfig"

# Generated on: 2025-09-05
