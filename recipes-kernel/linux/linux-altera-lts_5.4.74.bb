SUMMARY = "Linux kernel for Intel FPGA SoC - 5.4.74"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 5.4.74"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.4.74"
SRCREV = "c901495c1c61edb145ad2714d5173ea93020d850"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

KBRANCH = "socfpga-5.4.74-lts"
KERNEL_REPO_PROTOCOL = "https"
KERNEL_REPO_URI = "github.com/altera-fpga/linux-socfpga.git"

require linux-altera.inc

# Generated on: 2025-09-05
