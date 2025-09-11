SUMMARY = "Linux kernel for Intel FPGA SoC - 5.10.70"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.10.70"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.10.70"
SRCREV = "105721e5bf919605756b2ecfef9dcb3af9428391"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.10.70-lts"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-05
