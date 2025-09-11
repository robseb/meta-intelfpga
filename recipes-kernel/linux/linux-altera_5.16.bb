SUMMARY = "Linux kernel for Intel FPGA SoC - 5.16"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.16"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.16"
SRCREV = "813cb0d24cd0cef4da36aa6d0f9d154291ac15e1"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.16"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-04
