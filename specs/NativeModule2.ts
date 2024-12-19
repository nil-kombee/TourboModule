// specs/MyGeoSpec.ts
import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';
export interface Spec extends TurboModule {
    geocodeAddress(address: string): Promise<string>;
    reverseGeocode(latitude: number, longitude: number): Promise<string>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('NativeModule2');
