package com.shop.dto;

import com.shop.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartException;

@Component
public class ProductImageComverter {

    public Product toProductEntity(int token, AddProductDTO addProductDTO)
    {
        Product product = new Product();
        product.setProdTitle(addProductDTO.getProd_title());
        product.setProdDescription(addProductDTO.getProd_description());
         product.setProdPrice(addProductDTO.getProd_price());
          product.setCatId(addProductDTO.getCat_id());
         product.setCompId(addProductDTO.getComp_id());
        product.setProdQty(addProductDTO.getProd_qty());
        product.setSellerId(token);

        try {
            product.setPhoto(addProductDTO.getPhoto().getBytes());
        } catch (Exception e) {
            throw new MultipartException("Can't convert MultipartFile to bytes : " + addProductDTO.getPhoto(), e);

        }
        return  product;











    }
}
