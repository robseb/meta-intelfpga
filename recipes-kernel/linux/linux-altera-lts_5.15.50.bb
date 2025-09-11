SUMMARY = "Linux kernel for Intel FPGA SoC - 5.15.50"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.15.50"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.15.50"
SRCREV = "d04f108694d86082901cf778b20345a0ac566dda"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.15.50-lts"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-05
