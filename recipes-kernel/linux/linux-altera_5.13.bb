SUMMARY = "Linux kernel for Intel FPGA SoC - 5.13"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.13"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.13"
SRCREV = "d3040907268d4d1f71d1b918d4f6ac1b86ce4611"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.13"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-04
