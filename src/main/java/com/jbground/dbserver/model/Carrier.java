package com.jbground.dbserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NT_M_CARRIER")
public class Carrier {

    @Id
    @Column(name = "ID")
    protected String name;

    @Column(name = "MAHCINENAME")
    protected String machineName = "";

    @Column(name = "UNITNAME")
    protected String unitName = "";

    @Column(name = "TYPE")
    protected String type = "ALL";

    @Column(name = "KIND")
    protected String kind = "";

    @Column(name = "STATE")
    protected String state = "";
}
