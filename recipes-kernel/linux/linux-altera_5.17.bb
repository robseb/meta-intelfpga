SUMMARY = "Linux kernel for Intel FPGA SoC - 5.17"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.17"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.17"
SRCREV = "accb8ba6a1f5b0da836ea96dab9a92fb9b84317c"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.17"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-04
