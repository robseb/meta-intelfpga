SUMMARY = "Linux kernel for Intel FPGA SoC - 6.6.37"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 6.6.37"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.6.37"
SRCREV = "346486b5245fb21b577dbb86a0d8d609bc5d8643"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-6.6.37-lts"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-05
