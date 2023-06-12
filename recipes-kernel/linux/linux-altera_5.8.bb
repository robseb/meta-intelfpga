## rsyocto GmbH & Co. KG * Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Linux Kernel 5.8 for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.8 for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "5.8"

# NOTE: Thu Aug 27 10:07:27 2020 -0500
SRCREV = "eb446787abdf0428c0057da2d88daabc39a32393"
SRCREV:machine:cyclone5 ?= "eb446787abdf0428c0057da2d88daabc39a32393"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"

SRC_URI:append_cyclone5 = " file://lbdaf.scc "
SRC_URI:append_arria5 = " file://lbdaf.scc "
SRC_URI:append_arria10 = " file://lbdaf.scc "

do_install[depends] += "virtual/kernel:do_shared_workdir"