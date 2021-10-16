## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2021

SUMMARY = "Linux Kernel 5.10.50 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.10.50 LTS for Intel PSG (ALTERA) SoC-FPGAs" 


LINUX_VERSION = "5.10.50"
LINUX_VERSION_SUFFIX = "-lts"

# Note: Sat Aug 7 00:04:18 2021 +0900
SRCREV = "ba770a59eaddc884beb61c1be2a9af2ec977bdb2"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"
LIC_FILES_CHKSUM = "file://COPYING;md5=1379a04c68890d1adb6869ea17899ff5"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "

