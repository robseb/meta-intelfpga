SUMMARY = "Linux kernel for Intel FPGA SoC - 5.4.104"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.4.104"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.4.104"
SRCREV = "ffb7fcb55f630220928e48a5aefd731a4b01d804"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.4.104-lts"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-05
