## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2024

SUMMARY = "Linux Kernel 6.1.68 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 6.1.68 LTS for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "6.1.68"
LINUX_VERSION_SUFFIX = "-lts"

# Note:  Tue Sep 26 04:14:15 2023 +0800
SRCREV = "d9816a2213846a68a462dc8b0cbc432d79b03114"
SRCREV:machine:cyclone5 ?= "d9816a2213846a68a462dc8b0cbc432d79b03114"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"