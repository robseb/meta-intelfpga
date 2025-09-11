SUMMARY = "Linux kernel for Intel FPGA SoC - 6.6.22"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 6.6.22"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.6.22"
SRCREV = "f939c80e4195178b511c7577e0dc2a570ca0a426"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-6.6.22-lts"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-05
