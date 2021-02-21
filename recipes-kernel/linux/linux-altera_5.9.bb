## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2021

SUMMARY = "Linux Kernel 5.9 for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.9 for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "5.9"

# Note: During development! (Commit from Sun Nov 1 14:02:56 2020)
SRCREV = "33adeccc30305e609ac81c4e48477329897f6792"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc   "
SRC_URI_append_arria10 = " file://lbdaf.scc "
