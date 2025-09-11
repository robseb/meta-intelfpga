SUMMARY = "Linux kernel for Intel FPGA SoC - 6.12.11"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 6.12.11"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.12.11"
SRCREV = "2f0b0270dbabe9acc602bd269b4f85253e8a6e6d"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-6.12.11-lts"

# Override the repository settings from linux-altera.inc
KERNEL_REPO = "git://github.com/altera-fpga/linux-socfpga.git"
SRC_URI = "${KERNEL_REPO};protocol=https;branch=${KBRANCH} \
           file://socfpga_defconfig"

require linux-altera.inc

# Generated on: 2025-09-05
