## rsyocto GmbH & Co. KG * Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Linux Kernel 6.0 for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 6.0 for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "6.0"

# NOTE: Thu Nov 24 11:33:16 2022 +0800
SRCREV = "968dfc188ae51e149edee8def0c18aee60ec4f77"
SRCREV:machine:cyclone5 ?= "968dfc188ae51e149edee8def0c18aee60ec4f77"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"
