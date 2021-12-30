## rsyocto GmbH & Co. KG * Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2021

SUMMARY = "Linux Kernel 5.14 for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.14 for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "5.14"

# NOTE: Date: Mon Nov 8 14:08:54 2021 -0600
SRCREV = "73c8c03ffdea4aaed3e100349af967d8c9faeea0"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "
