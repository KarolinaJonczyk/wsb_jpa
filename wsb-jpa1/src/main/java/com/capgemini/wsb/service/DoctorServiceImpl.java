package com.capgemini.wsb.service;
import com.capgemini.wsb.dto.DoctorTO;

public interface DoctorServiceImpl
{
    DoctorTO findById(final Long id);
}