SUMMARY = "Linux kernel for Intel FPGA SoC - 5.14"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.14"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.14"
SRCREV = "73c8c03ffdea4aaed3e100349af967d8c9faeea0"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.14"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-04
