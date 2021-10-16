## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2021

SUMMARY = "Linux Kernel 5.4.124 for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.4.124 for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "5.4.124"
LINUX_VERSION_SUFFIX = "-lts"

# Note:  Fri Aug 20 23:44:17 2021 -0400
SRCREV = "cdb318393975f4bf9a392fb15af74aad45c57245"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc   "
SRC_URI_append_arria10 = " file://lbdaf.scc "
