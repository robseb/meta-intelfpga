SUMMARY = "Linux kernel for Intel FPGA SoC - 5.10.120"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.10.120"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.10.120"
SRCREV = "2d7fbf2c4919f20fca79ca8d2b37fc15032d7b7f"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.10.120-lts"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-05
