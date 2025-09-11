SUMMARY = "Linux kernel for Intel FPGA SoC - 5.11"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.11"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.11"
SRCREV = "27e8b9142bfe1aab0494e08692214f3438a4ea67"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.11"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-04
