## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2021

SUMMARY = "Linux Kernel 5.11 for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.11 for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "5.11"

# Note: Thu Apr 1 13:09:06 2021 -0500
SRCREV = "164aa6229f7024bc6f8984e7b820e607e8234f61"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc   "
SRC_URI_append_arria10 = " file://lbdaf.scc "
