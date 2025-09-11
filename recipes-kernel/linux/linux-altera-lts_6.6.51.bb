SUMMARY = "Linux kernel for Intel FPGA SoC - 6.6.51"
DESCRIPTION = "Linux kernel for Intel FPGA SoC - 6.6.51"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.6.51"
SRCREV = "7dddbad0a3a725b140b8fc4621159cd4628374a8"
PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION_EXTENSION = "-altera"

# Set branch name for linux-altera.inc
KERNEL_REPO = "git://github.com/altera-opensource/linux-socfpga.git"
KERNEL_PROT = "https"
LINUX_VERSION_PREFIX = "socfpga-"
LINUX_VERSION_SUFFIX = "-lts"

require linux-altera.inc
