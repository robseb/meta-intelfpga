## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2021

SUMMARY = "Linux Kernel 5.13 for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.13 for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "5.13"

# NOTE: Thu Sep 9 22:25:16 2021 +0800
SRCREV = "d91a80a66076c0863ff934537da8f860a75ab618"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=67ffc8fb2f92965aa3329ebebc6f2bcf"

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "
