package com.aquiteturahexa.techchallenge.adapters.controllers;

import java.util.Map;

import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.ItemMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aquiteturahexa.techchallenge.core.model.ItemType;
import com.aquiteturahexa.techchallenge.core.ports.in.ListItemsPortIn;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ListItemsRestController {

        private final ListItemsPortIn listItemsPortIn;

        @GetMapping(path = "/api/v1/items")
        public ResponseEntity<?> getById(
                        @RequestHeader Map<String, String> headers,
                        @RequestParam(value = "itemType", required = false) String itemType

        ) {
                var filterByType = StringUtils.isNotEmpty(itemType);
                var itemTypeEnum = filterByType ? ItemType.valueOf(itemType) : null;

                var items = filterByType
                                ? listItemsPortIn.getAllByType(itemTypeEnum)
                                : listItemsPortIn.getAll();

                return items.isEmpty()
                                ? ResponseEntity.notFound().build()
                                : ResponseEntity.ok(ItemMapper.toDto(items));

        }

}
