
## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2021

SUMMARY = "Linux Kernel 5.4.74 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.4.74 LTS for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "5.4.74"
LINUX_VERSION_SUFFIX = "-lts"

SRCREV = "f8f8365913778a80bdc3ddd8548b85298b4588bc"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "

