package br.edu.ifpr.persistproject.model;

import java.util.Objects;

public class Department {

    private Integer id_dep;
    private String name_dep;

    public Integer getId_dep() {
        return id_dep;
    }

    public void setId_dep(Integer id_dep) {
        this.id_dep = id_dep;
    }

    public String getName_dep() {
        return name_dep;
    }

    public void setName_dep(String name_dep) {
        this.name_dep = name_dep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id_dep, that.id_dep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_dep);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id_dep=" + id_dep +
                ", name_dep='" + name_dep + '\'' +
                '}';
    }
}
