## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Linux Kernel for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel for Intel PSG (ALTERA) SoC-FPGAs" 
LICENSE = "MIT"

KERNEL_REPO ?= "git://github.com/altera-opensource/linux-socfpga.git"
KERNEL_PROT ?= "https"

require recipes-kernel/linux/linux-yocto.inc

inherit kernel

DEPENDS += "bc-native"

KBRANCH = "${LINUX_VERSION_PREFIX}${LINUX_VERSION}${LINUX_VERSION_SUFFIX}"

SRC_URI = "${KERNEL_REPO};protocol=${KERNEL_PROT};branch=${KBRANCH} \
            file://socfpga_defconfig"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Kernel CONFIG_LOCALVERSION
LINUX_VERSION_EXTENSION ?= "-altera" 

# Build branch name
LINUX_VERSION_PREFIX ?= "socfpga-"
LINUX_VERSION_SUFFIX ?= ""

KERNEL_IMAGETYPE ?= "zImage"
MACHINE_EXTRA_RRECOMMENDS = " kernel-modules "
MACHINE_FEATURES = "kernel26"
 
#SRCREV ?= "${AUTOREV}"
#SRCREV_machine ?= "${AUTOREV}"
PV = "${LINUX_VERSION}${LINUX_VERSION_SUFFIX}"
#PV:append = "+git${SRCPV}"

KERNEL_DEFCONFIG = "${THISDIR}/socfpga_defconfig"
KERNEL_DEFCONFIG_cyclone5 = "${THISDIR}/socfpga_defconfig"
