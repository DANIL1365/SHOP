SELECT
    `shop_2`.user.*,                          -- Foreign key schema
    `TABLE_NAME`,                            -- Foreign key table
    `COLUMN_NAME`                            -- Foreign key column
FROM `INFORMATION_SCHEMA`.`KEY_COLUMN_USAGE`
WHERE `TABLE_SCHEMA` = 'shop_2'
  AND   `REFERENCED_TABLE_NAME` = 'YourTableName'