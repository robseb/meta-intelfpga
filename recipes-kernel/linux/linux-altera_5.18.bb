SUMMARY = "Linux kernel for Intel FPGA SoC - 5.18"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.18"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.18"
SRCREV = "f9dc9b56aeb52f9e95c899fe77d1a7559460b3ac"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.18"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-04
