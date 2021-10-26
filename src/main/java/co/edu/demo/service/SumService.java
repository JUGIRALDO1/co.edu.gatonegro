package co.edu.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SumService implements ISumService{
    @Override
    public double SumNumber(double a, double b) {
        return a+b;
    }
}
