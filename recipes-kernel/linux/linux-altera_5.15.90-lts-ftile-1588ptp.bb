SUMMARY = "Linux kernel for Intel FPGA SoC - 5.15.90-lts-ftile-1588ptp"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.15.90-lts-ftile-1588ptp"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

require linux-altera.inc

LINUX_VERSION = "5.15.90-lts-ftile-1588ptp"
SRCREV = "c53eeb0f060f32da33e7f181a5d65a66abf83481"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.15.90-lts-ftile-1588ptp"

# Override the SRC_URI and repository settings from linux-altera.inc
KERNEL_REPO = "git://github.com/altera-fpga/linux-socfpga.git"
SRC_URI = "${KERNEL_REPO};protocol=https;branch=${KBRANCH}"

# Generated on: 2025-09-05
