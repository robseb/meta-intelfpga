SUMMARY = "Linux kernel for Intel FPGA SoC - 5.10.50"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.10.50"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.10.50"
SRCREV = "4a7814a4e2140945fff9d18c02794ae7dea801e8"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.10.50-lts"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-05
