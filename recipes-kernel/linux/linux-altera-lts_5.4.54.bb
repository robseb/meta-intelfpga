## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Linux Kernel 5.4.54 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.4.54 LTS for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "5.4.54"
LINUX_VERSION_SUFFIX = "-lts"

# Note:  Fri Aug 20 23:44:17 2021 -0400
SRCREV = "d8fb6a37e8940e8322ef254b56e21b9543955d00"
SRCREV:machine:cyclone5 ?= "d8fb6a37e8940e8322ef254b56e21b9543955d00"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"

SRC_URI:append_cyclone5 = " file://lbdaf.scc "
SRC_URI:append_arria5 = " file://lbdaf.scc   "
SRC_URI:append_arria10 = " file://lbdaf.scc "
