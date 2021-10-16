## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2021

SUMMARY = "Linux Kernel 5.12 for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.12 for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "5.12"

# Note: Wed Sep 8 13:18:02 2021 -0500
SRCREV = "4b159443997466eb36133c59e7aaef4e76f62f4a"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc   "
SRC_URI_append_arria10 = " file://lbdaf.scc "
