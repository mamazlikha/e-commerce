export * from './actuator.service';
import { ActuatorService } from './actuator.service';
export * from './addProductsController.service';
import { AddProductsControllerService } from './addProductsController.service';
export * from './editProductController.service';
import { EditProductControllerService } from './editProductController.service';
export * from './findAllProductsController.service';
import { FindAllProductsControllerService } from './findAllProductsController.service';
export * from './getProductByIdController.service';
import { GetProductByIdControllerService } from './getProductByIdController.service';
export const APIS = [ActuatorService, AddProductsControllerService, EditProductControllerService, FindAllProductsControllerService, GetProductByIdControllerService];