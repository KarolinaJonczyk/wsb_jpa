package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public class VisitMapper
{
    public static VisitTO mapToTO(final VisitEntity visitEntity)
    {
        if (visitEntity == null)
        {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setDoctor(visitEntity.getDoctor());
        visitTO.setTimeVisit(visitEntity.getVisitTime());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setPatient(visitEntity.getPatient());

        return visitTO;
    }

    public static VisitEntity TOtoMap(final VisitTO visitTO)
    {
        if (visitTO == null)
        {
            return null;
        }
        final VisitEntity  visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setDoctor(visitTO.getDoctor());
        visitEntity.setVisitTime(visitTO.getTime());
        visitEntity.setDescription();visitTO.getDescription();
        visitEntity.setPatient(visitTO.getPatient());
        return visitEntity;
    }
}