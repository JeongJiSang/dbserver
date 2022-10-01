package com.jbground.dbserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NT_R_MACHINE")
public class Machine {

    @Id
    @Column(name = "ID")
    protected String name;

    @Column(name = "FACTORYNAME")
    protected String factoryName = "";

    @Column(name = "SHOPNAME")
    protected String shopName = "";

    @Column(name = "AREANAME")
    protected String areaName = "";

    @Column(name = "BAYNAME")
    protected String bayName = "";

}
