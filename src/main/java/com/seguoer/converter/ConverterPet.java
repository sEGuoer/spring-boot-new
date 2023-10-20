package com.seguoer.converter;

import com.seguoer.po.Pet;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ConverterPet implements Converter<String,Pet> {
    @Override
    public Pet convert(String source) {
        if (source != null && !source.equals("")){
            String[] stringList = source.split(",");
            Pet pet = new Pet(stringList[0],Integer.parseInt(stringList[1]));
            return pet;
        }
        return null;
    }
}
