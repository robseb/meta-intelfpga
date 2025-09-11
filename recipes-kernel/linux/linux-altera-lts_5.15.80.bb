SUMMARY = "Linux kernel for Intel FPGA SoC - 5.15.80"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.15.80"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

require linux-altera.inc

LINUX_VERSION = "5.15.80"
SRCREV = "dacc5e3eb584327cf008331e91f80a875a5af908"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.15.80-lts"

# Override the SRC_URI and repository settings from linux-altera.inc
KERNEL_REPO = "git://github.com/altera-fpga/linux-socfpga.git"
SRC_URI = "${KERNEL_REPO};protocol=https;branch=${KBRANCH}"

# Use the socfpga_defconfig from the Linux source tree
KBUILD_DEFCONFIG = "socfpga_defconfig"
KERNEL_DEFCONFIG = ""

# Generated on: 2025-09-05
