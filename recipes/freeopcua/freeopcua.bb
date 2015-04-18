DESCRIPTION = "Freeopcua server"

DEPENDS += " libxml2 boost python libtool"


LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRCREV= "d22debb66a35d37461faab6e732f58c0b8f90d7a"
#SRC_URI = "git:///home/treww/work/freeopcua"
SRC_URI = "git://github.com/treww/freeopcua"
S = "${WORKDIR}/git"
PR = "r0"


INITSCRIPT_NAME = "opcuaserver"
INIT_SCRIPT_PARAM = "defaults"


inherit autotools update-rc.d

FILES_${PN} += "/etc/init.d/freeopcua"

EXTRA_OECONF = " --disable-python-bindings"

do_install_append () {
  chmod a+x ${D}${sysconfdir}/init.d/opcuaserver
  install -d ${D}${localstatedir}
  install -d ${D}${localstatedir}/log
  install -d ${D}${localstatedir}/log/opcua
}

