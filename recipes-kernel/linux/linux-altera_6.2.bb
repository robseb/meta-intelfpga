## rsyocto GmbH & Co. KG * Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Linux Kernel 6.2 for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 6.2 for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION ?= "6.2"


# NOTE: Thu Nov 24 11:33:16 2022 +0800
SRCREV = "dfafb19e3282486147da20688f792ae61fa3cee5"
SRCREV:machine:cyclone5 ?= "dfafb19e3282486147da20688f792ae61fa3cee5"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"

SRC_URI:append_cyclone5 = " file://lbdaf.scc "
SRC_URI:append_arria5   = " file://lbdaf.scc "
SRC_URI:append_arria10  = " file://lbdaf.scc "