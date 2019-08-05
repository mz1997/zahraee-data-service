package com.mz.data.model;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
public abstract class BaseEntity <PK extends Serializable> {
}
