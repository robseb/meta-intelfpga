## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Linux Kernel for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel for Intel PSG (ALTERA) SoC-FPGAs" 
LICENSE = "MIT"

require recipes-kernel/linux/linux-yocto.inc
#require linux-altera-configs.inc


KERNEL_REPO ?= "git://github.com/altera-opensource/linux-socfpga.git"
KERNEL_PROT ?= "https"

DEPENDS += "bc-native"

# Kernel CONFIG_LOCALVERSION
LINUX_VERSION_EXTENSION ?= "-altera"

# Build branch name
LINUX_VERSION_PREFIX ?= "socfpga-"
LINUX_VERSION_SUFFIX ?= ""

KERNEL_IMAGETYPE ?= "zImage"
MACHINE_EXTRA_RRECOMMENDS = " kernel-modules"
MACHINE_FEATURES = "kernel26"

#SRCREV ?= "${AUTOREV}"
#SRCREV_machine ?= "${AUTOREV}"
PV = "${LINUX_VERSION}${LINUX_VERSION_SUFFIX}"
PV:append = "+git${SRCPV}"

KBRANCH ?= "${LINUX_VERSION_PREFIX}${LINUX_VERSION}${LINUX_VERSION_SUFFIX}"

KBUILD_DEFCONFIG ?= "Kernel_conf_intelsocfpga_armv7a.config"
#KERNEL_DEFCONFIG_cyclone5 = "Kernel_conf_intelsocfpga_armv7a.config"


SRC_URI = "${KERNEL_REPO};protocol=${KERNEL_PROT};branch=${KBRANCH}"

do_preconfigure:prepend() {
   cp ${KERNEL_DEFCONFIG} ${WORKDIR}/defconfig
}